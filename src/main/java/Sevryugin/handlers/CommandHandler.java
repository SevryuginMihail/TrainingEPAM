package Sevryugin.handlers;

import Sevryugin.exception.CommandException;

/**
 * Интерфейс для реализации команд работы с файлом
 */
public interface CommandHandler {
    void execute(String command) throws CommandException;
}
