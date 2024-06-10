package ma.miaad.partie3springangularanasmansour;

import ma.miaad.partie3springangularanasmansour.entities.Payment;
import ma.miaad.partie3springangularanasmansour.entities.PaymentStatus;
import ma.miaad.partie3springangularanasmansour.entities.PaymentType;
import ma.miaad.partie3springangularanasmansour.entities.Student;
import ma.miaad.partie3springangularanasmansour.repository.PaymentRepository;
import ma.miaad.partie3springangularanasmansour.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
@SpringBootApplication
public class Partie3SpringAngularAnasMansourApplication {

    public static void main(String[] args) {
        SpringApplication.run(Partie3SpringAngularAnasMansourApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Anas").code("112233").programId("MIAAD")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Mansour").code("112244").programId("MIAAD")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Salah").code("112255").programId("SMIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Ahmed").code("112266").programId("PC")
                    .build());
            PaymentType[] paymentTypes=PaymentType.values();
            Random random =new Random();
            studentRepository.findAll().forEach(st->{
                for (int i = 0; i <10 ; i++) {
                    int index =random.nextInt(paymentTypes.length);
                    Payment payment=Payment.builder()
                            .amount(1000+(int)(Math.random()*20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };
    }

}