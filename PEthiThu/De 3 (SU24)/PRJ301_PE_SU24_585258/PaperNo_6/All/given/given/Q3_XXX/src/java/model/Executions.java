/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Executions {
    int executionID;
    int result;
    Vector<ExecutionItems> arr;

    public Executions() {
    }

    public Executions(int executionID, int result, Vector<ExecutionItems> arr) {
        this.executionID = executionID;
        this.result = result;
        this.arr = arr;
    }

    public int getExecutionID() {
        return executionID;
    }

    public void setExecutionID(int executionID) {
        this.executionID = executionID;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Vector<ExecutionItems> getArr() {
        return arr;
    }

    public void setArr(Vector<ExecutionItems> arr) {
        this.arr = arr;
    }
    
    
}
