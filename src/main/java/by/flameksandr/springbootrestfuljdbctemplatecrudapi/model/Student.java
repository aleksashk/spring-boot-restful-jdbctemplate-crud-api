package by.flameksandr.springbootrestfuljdbctemplatecrudapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private long contactNumber;
    private String address;
}
