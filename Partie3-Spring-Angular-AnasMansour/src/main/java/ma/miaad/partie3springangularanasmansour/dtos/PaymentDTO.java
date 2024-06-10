package ma.miaad.partie3springangularanasmansour.dtos;

import ma.miaad.partie3springangularanasmansour.entities.PaymentStatus;
import ma.miaad.partie3springangularanasmansour.entities.PaymentType;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
}
