package zrx.com.DesignPatterns.CommandPattern.command;


/**
 * 命令接口
 */


public interface Commmand {
    /**
     * 执行命令
     */
    void execute();

    /**
     * 撤销命令
     */
    void undo();

}
