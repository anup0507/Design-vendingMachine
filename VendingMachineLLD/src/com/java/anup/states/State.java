package com.java.anup.states;

public interface State {

    public void ChooseProduct();

    public void CollectMoney();
    public void DispenseProduct();

    public void CancelTransaction();
    public void NotifyAdminUsers();
}
