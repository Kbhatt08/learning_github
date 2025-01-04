package ai.miko.filedatabase.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ai.miko.filedatabase.pojo.FileTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Repository
public class FileTableRepository extends ArrayList<FileTable> {
    
}
