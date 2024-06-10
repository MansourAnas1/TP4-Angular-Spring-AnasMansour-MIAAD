package ma.miaad.partie3springangularanasmansour.repository;

import ma.miaad.partie3springangularanasmansour.entities.Payment;
import ma.miaad.partie3springangularanasmansour.entities.PaymentStatus;
import ma.miaad.partie3springangularanasmansour.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List <Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);

}
