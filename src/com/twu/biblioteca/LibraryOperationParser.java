package com.twu.biblioteca;

/**
 * Created by qiyuesong on 21/6/15.
 */
public class LibraryOperationParser {

    public static BookOperation parseOperation(String operationString){
        String operationContent = operationString.trim().toLowerCase();
        String operation = operationContent.substring(0, operationContent.indexOf(' '));
        String target = operationContent.substring(operationContent.indexOf(' ') + 1);
        if(operation.equals("borrow")){
            return new BookOperation(LibraryOptionType.LIBRARY_OPTION_BORROW, target);
        }else if(operation.equals("return")){
            return new BookOperation(LibraryOptionType.LIBRARY_OPTION_RETURN, target);
        }else{
            return new BookOperation(LibraryOptionType.LIBRARY_OPTION_UNKNOWN, "");
        }
    }
}
