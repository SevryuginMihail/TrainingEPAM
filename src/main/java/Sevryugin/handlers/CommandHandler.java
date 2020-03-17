package Sevryugin.handlers;

import Sevryugin.exception.CommandException;

public interface CommandHandler {
    void execute(String string) throws CommandException;
}
