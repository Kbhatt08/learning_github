package ai.miko.filedatabase.pojo;

import java.util.ArrayList;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.sf.jsqlparser.schema.Column;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileTable extends ArrayList<FileColumn>{
    String fileTableName;

    @Override
    public String toString() {
        return "FileTable [fileTableName=" + fileTableName + ", elementData=" + Arrays.toString(this.toArray())
                + ", modCount=" + this.modCount + ", getFileTableName()=" + getFileTableName() + ", hashCode()=" + hashCode()
                + ", isEmpty()=" + isEmpty() + ", iterator()=" + iterator() + ", listIterator()=" + listIterator()
                + ", size()=" + size() + ", spliterator()=" + spliterator() + ", toArray()="
                + Arrays.toString(toArray()) + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
    }


    
}
