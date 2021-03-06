package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public TransactionDAO() {
    }

    @Override
    public String toString() {
        return "TransactionDAO{" +
                "transactions=" + (transactions == null ? null : Arrays.asList(transactions)) +
                '}';
    }

    public Transaction save(Transaction transaction) throws Exception {

        // сумма транзакции больше указанного лимита
        // сумма транзакций за день больше дневного лимита
        // количество транзаций за день больше указанного лимита
        // если город платы (совершения транзации) не разрешен
        // не хватило места

        validate(transaction);

        int index = indexFirstAvailablePlace();

        transactions[index] = transaction;
        return transactions[index];
    }

    private int numberSavedTransactions() {
        int res = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                res++;
        }
        return res;
    }

    private int indexFirstAvailablePlace() throws InternalServerException {
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null)
                return index;

            index++;
        }
        throw new InternalServerException("there is no availabe place ");
    }

    private void put(Transaction transaction) {
        for (Transaction tr : transactions) {
            if (tr == null) {
                tr = transaction;
                break;
            }
        }
    }//put

    private void amountIsValid(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");
    }

    private void limitTransactionsPerDayAmount(Transaction transaction) throws Exception {
        int sum = transaction.getAmount();

        Transaction[] trPerCurDay = getTransactionsPerDay(new Date());

        for (Transaction tr : trPerCurDay) {
            sum += tr.getAmount();
        }


        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }
    }

    private void limitTransactionsPerDayCount(Transaction transaction) throws Exception {
        int count = 1;
        Transaction[] trPerCurDay = getTransactionsPerDay(new Date());

        for (Transaction tr : trPerCurDay) {
            count++;
        }
        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }
    }

    private void cityAvailable(Transaction transaction) throws Exception {
        if (!utils.availableCity(transaction.getCity())) {
            throw new BadRequestException("City is not available " + transaction.getId() + ". Can't be saved");
        }
    }

    private void freeSpace(Transaction transaction) throws Exception {
        if (!thereIsFreeSpace())
            throw new InternalServerException("no free memory available " + transaction.getId() + ". Can't be saved");
    }


    private void checkDuplicateTransaction(Transaction transaction) throws Exception {
        //перевіряємо чи є в масиві така уже транзакція
        if (findSameTransaction(transaction)) {
            throw new BadRequestException("This transaction is already exist " + transaction.getId() + ". Can't be saved");
        }
    }


    private void validate(Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new BadRequestException("Transaction is null ");
        }
        amountIsValid(transaction);
        limitTransactionsPerDayAmount(transaction);
        limitTransactionsPerDayCount(transaction);
        cityAvailable(transaction);
        freeSpace(transaction);
        checkDuplicateTransaction(transaction);
    }//validate


    public boolean findSameTransaction(Transaction transaction) {
        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                return true;
            }
        }
        return false;
    }

    public boolean thereIsFreeSpace() {
        for (Transaction tr : transactions) {
            if (tr == null)
                return true;
        }
        return false;
    }

    public Transaction[] transactionList() {
        int number = numberSavedTransactions();

        Transaction[] trs = new Transaction[number];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                trs[index] = tr;
                index++;
            }

        }//for

        return trs;
    }


    public Transaction[] transactionList(String city) {
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && (tr.getCity() == city)) {
                index++;
            }
        }


        Transaction[] trs = new Transaction[index];
        index = 0;
        for (Transaction tr : transactions) {
            if ((tr != null) && (tr.getCity() == city)) {
                trs[index] = tr;
                index++;
            }
        }
        return trs;
    }

    public Transaction[] transactionList(int amount) {
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && (tr.getAmount() == amount)) {
                index++;
            }
        }


        Transaction[] trs = new Transaction[index];
        index = 0;
        for (Transaction tr : transactions) {
            if ((tr != null) && (tr.getAmount() == amount)) {
                trs[index] = tr;
                index++;
            }
        }
        return trs;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;

            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;

    }
}
