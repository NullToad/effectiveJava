package com.sawyer.effective.objectConstructionAndDestruction.singleton;

/**
 * @Author: Sawyer
 * @Description: 单例的最佳实践：枚举
 * @Date: Created in 5:02 PM 2019/2/2
 */

public enum Sawyer {
    INSTANCE("Sawyer");

    private String name;
    private String game;

    private Sawyer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
