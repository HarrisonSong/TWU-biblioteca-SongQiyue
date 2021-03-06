package com.twu.biblioteca;

/**
 * Created by qiyuesong on 18/6/15.
 */
public class SystemMessager {

    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca library management system.";
    public static final String INVALID_MENU_OPTION_MESSAGE = "Select a valid option!";
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy it.";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That item is not available.";
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning it.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid item to return.";
    public static final String INVALID_BOOK_OPTION_MESSAGE = "Your operation is not available.";
    public static final String REMINDING_MESSAGE = "Please type in the operation you want to do: ";
    public static final String GOODBYE_MESSAGE = "Thank you for using our system. Good bye!";


    public static void showWelcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void showRemindingMessage(){
        System.out.print(REMINDING_MESSAGE);
    }

    public static void showResponseMessage(SystemMessageType type){
        String messageForResponse = "";
        switch(type){
            case INVALID_MENU_OPTION:{
                messageForResponse = INVALID_MENU_OPTION_MESSAGE;
                break;
            }
            case SUCCESSFUL_CHECKOUT:{
                messageForResponse = SUCCESSFUL_CHECKOUT_MESSAGE;
                break;
            }
            case UNSUCCESSFUL_CHECKOUT:{
                messageForResponse = UNSUCCESSFUL_CHECKOUT_MESSAGE;
                break;
            }
            case SUCCESSFUL_RETURN:{
                messageForResponse = SUCCESSFUL_RETURN_MESSAGE;
                break;
            }

            case UNSUCCESSFUL_RETURN:{
                messageForResponse = UNSUCCESSFUL_RETURN_MESSAGE;
                break;
            }
            case INVALID_LIBRARY_ITEM_OPTION:{
                messageForResponse = INVALID_BOOK_OPTION_MESSAGE;
                break;
            }
            default:
                break;
        }
        System.out.println(messageForResponse);
    }

    public static void showGoodByeMessage(){
        System.out.println(GOODBYE_MESSAGE);
    }
}
