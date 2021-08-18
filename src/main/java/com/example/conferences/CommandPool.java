package com.example.conferences;

import java.util.HashMap;
import java.util.Map;

public class CommandPool {
    private static final Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("loginCommand", new LoginCommand());
    }

    public static Command getCommand(String commandName) {
        return COMMANDS.get(commandName);
    }
}
