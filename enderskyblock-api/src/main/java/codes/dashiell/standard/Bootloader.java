package codes.dashiell.standard;

public interface Bootloader {

    SimpleResult enable();
    void disable();

    void registerCommands();
    void registerEvents();

}
