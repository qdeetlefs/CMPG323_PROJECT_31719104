package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
    "               at" +
    "               FROM " +
    "               AccountType at" +
    "               WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Modifying
    @Query(value = "DELETE FROM " +
            "               AccountType at" +
            "               WHERE at.mnemonic = :mnemonic ")
    void deleteAccountType(String mnemonic);;

    @Modifying
    @Query(value = "UPDATE AccountType at set at.accountTypeName = :newAccountType_name, at.creationDate = :newCreationDate where at.mnemonic = :mnemonic")
    void updateAccountType(String mnemonic, String newAccountType_name, LocalDate newCreationDate);

    @Query(value = "SELECT " +
            "               at" +
            "               FROM " +
            "               AccountType at" +
            "               WHERE at.mnemonic = :accountTypeMnemonic ")
    AccountType getAccountTypeDbEntityByMnemonic(String accountTypeMnemonic);
}
