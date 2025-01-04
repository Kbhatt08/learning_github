package ai.miko.filedatabase.ServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.miko.filedatabase.pojo.FileColumn;
import ai.miko.filedatabase.pojo.FileTable;
import ai.miko.filedatabase.pojo.Metadata;
import ai.miko.filedatabase.repository.FileTableRepository;
import ai.miko.filedatabase.service.FileService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.insert.Insert;
@Service
@Slf4j
public class FileServiceImpl implements FileService{

    static int id=0;
    List<Metadata> metadataList = new ArrayList<>();
    @Autowired
    FileTableRepository fileTableRepository;
    
    @Override
    public String process(String code) {
         try {
        Statement statement = CCJSqlParserUtil.parse(code);
        if (statement instanceof CreateTable) {
            CreateTable createTable = (CreateTable) statement;
            createTable(createTable);    
            return "Table created successfully";
        }
        else if (statement instanceof Insert) {
            Insert insert = (Insert) statement;
            insertData(insert);   
            return "Table created successfully";
        }
         else {
            return "Invalid SQL statement";
        }
    } catch (Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return "Failed to create table";
    }
    }

    private void insertData(Insert insert) {
        
    }

    public static int generateId(){
        return id++;
    }

    private void createTable(CreateTable createTable) {
        String tableName=createTable.getTable().getFullyQualifiedName();
        metadataList.forEach(i->{
            if(i.getTableName().equals(tableName))
            throw new RuntimeException("Table already exists");
        });
        FileTable fileTable= new FileTable(tableName);
            log.info("Table name: " + tableName);
            Metadata metadata= new Metadata();
            metadata.setTableName(tableName);
            metadata.setUUID(String.valueOf(generateId()));
            FileColumn fileColumn= new FileColumn();
            Map<String,String> columnDefinitiondata= new HashMap<>();
            for (ColumnDefinition columnDefinition : createTable.getColumnDefinitions()) {
                fileColumn.add(columnDefinition.getColumnName());
                columnDefinitiondata.put(columnDefinition.getColumnName(),columnDefinition.getColDataType().toString());
                log.info(columnDefinition.getColumnName()+"  "+columnDefinition.getColDataType());
            }
        fileTable.add(fileColumn);
        metadata.setColumnsDefinations(columnDefinitiondata);
        metadataList.add(metadata);
        fileTableRepository.add(fileTable);
        log.info("ALL Data till now "+metadataList);
        log.info("ALL Data till now "+fileTableRepository);
    }

    
    
}
