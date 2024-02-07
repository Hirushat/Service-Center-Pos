package edu.icet.dto.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.scene.control.Button;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerTm extends RecursiveTreeObject<CustomerTm> {
    private String custId;
    private String custName;
    private String contactNumber;
    private String eMailAddress;
    private Button btn;
}
