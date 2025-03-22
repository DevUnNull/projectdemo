/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ExecutionItems {
    int executionItemID;
    int arrayItem;

    public ExecutionItems() {
    }

    public ExecutionItems(int executionItemID, int arrayItem) {
        this.executionItemID = executionItemID;
        this.arrayItem = arrayItem;
    }

    public int getExecutionItemID() {
        return executionItemID;
    }

    public void setExecutionItemID(int executionItemID) {
        this.executionItemID = executionItemID;
    }

    public int getArrayItem() {
        return arrayItem;
    }

    public void setArrayItem(int arrayItem) {
        this.arrayItem = arrayItem;
    }
    
    
}
