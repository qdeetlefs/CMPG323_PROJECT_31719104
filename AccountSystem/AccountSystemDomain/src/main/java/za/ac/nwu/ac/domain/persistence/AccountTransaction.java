package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "demo_account_tx", schema = "cmpg323_accountsystem")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = -4136429093512788169L;

    private long transactionId;
    private AccountType accountType;
    private long memberId;
    private long amount;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(long transactionId, AccountType accountType, long memberId, long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @SequenceGenerator(name = "CMPG323_ACCOUNTSYSTEM_GENERIC_SEQ", sequenceName = "cmpg323_accountsystem.CMPG323_ACCOUNTSYSTEM_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CMPG323_ACCOUNTSYSTEM_GENERIC_SEQ")
    @Column(name = "ACCOUNT_TX_ID")
    public long getTransactionId() {
        return transactionId;
    }

    @Column(name = "MEMBER_ID")
    public long getMemberId() {
        return memberId;
    }

    @Column(name = "AMOUNT")
    public long getAmount() {
        return amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAccountType(AccountType AccountType) {
        this.accountType = AccountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return transactionId == that.transactionId && memberId == that.memberId && amount == that.amount && Objects.equals(accountType, that.accountType) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}