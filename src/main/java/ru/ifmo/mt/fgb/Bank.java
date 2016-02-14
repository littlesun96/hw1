package ru.ifmo.mt.fgb;

/**
 * Bank interface.
 */
public interface Bank {
    /**
     * The maximal amount that can be kept in a bank account.
     */
    long MAX_AMOUNT = 1_000_000_000_000_000L;

    /**
     * Returns number of accounts in this bank.
     *
     * @return number of accounts in this bank.
     */
    int getNumberOfAccounts();

    /**
     * Returns current amount in the specified account.
     *
     * @param index account index from 0 to {@link #getNumberOfAccounts() n}-1.
     * @return amount in account.
     * @throws IndexOutOfBoundsException when index is invalid account index.
     */
    long getAmount(int index);

    /**
     * Returns total amount deposited in this bank.
     *
     * @return total amount deposited in this bank.
     */
    long getTotalAmount();

    /**
     * Deposits specified amount to account.
     *
     * @param index  account index from 0 to {@link #getNumberOfAccounts() n}-1.
     * @param amount positive amount to deposit.
     * @return resulting amount in account.
     * @throws IllegalArgumentException  when amount <= 0.
     * @throws IndexOutOfBoundsException when index is invalid account index.
     * @throws IllegalStateException     when deposit will overflow account above {@link #MAX_AMOUNT}.
     */
    long deposit(int index, long amount);

    /**
     * Withdraws specified amount from account.
     *
     * @param index  account index from 0 to {@link #getNumberOfAccounts() n}-1.
     * @param amount positive amount to withdraw.
     * @return resulting amount in account.
     * @throws IllegalArgumentException  when amount <= 0.
     * @throws IndexOutOfBoundsException when index is invalid account index.
     * @throws IllegalStateException     when account does not enough to withdraw.
     */
    long withdraw(int index, long amount);

    /**
     * Transfers specified amount from one account to another account.
     *
     * @param fromIndex account index to withdraw from.
     * @param toIndex   account index to deposit to.
     * @param amount    positive amount to transfer.
     * @throws IllegalArgumentException  when amount <= 0 or fromIndex == toIndex.
     * @throws IndexOutOfBoundsException when account indices are invalid.
     * @throws IllegalStateException     when there is not enough funds in source account or too much in target one.
     */
    void transfer(int fromIndex, int toIndex, long amount);
}
