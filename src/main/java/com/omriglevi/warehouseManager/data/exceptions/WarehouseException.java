package com.omriglevi.warehouseManager.data.exceptions;

public class WarehouseException extends Exception{
    public WarehouseException(String message, String componentName) {
        super("Warehouse service exception accured in :" + componentName + "With Message :" + message  );
    }
}
