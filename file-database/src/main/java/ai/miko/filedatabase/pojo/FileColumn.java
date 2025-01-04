package ai.miko.filedatabase.pojo;

import java.util.ArrayList;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
public class FileColumn extends ArrayList<Object> {
    @Override
    public String toString() {
        return this.size()+"  FileColumn [] "+Arrays.toString(this.toArray());
    }
}
