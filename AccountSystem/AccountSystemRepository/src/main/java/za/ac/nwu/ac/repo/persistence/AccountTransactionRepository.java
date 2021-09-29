package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {


    @Query(value = "SELECT " +
            "               at" +
            "               FROM " +
            "               AccountTransaction at" +
            "               WHERE at.memberId = :memberId ")
    AccountTransaction findByMemberId(Long memberId);

    @Modifying
    @Query(value = "UPDATE AccountTransaction at set at.amount = at.amount + :milesToAdd where at.memberId = :memberId")
    void addMiles(Long memberId, Long milesToAdd);
}
