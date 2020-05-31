import java.util.Properties;

import com.codingame.gameengine.runner.MultiplayerGameRunner;

public class Spring2020Main {
    public static void main(String[] args) {
        // read cli args
        Options opts = new Options().read(args);
        String cli1 = opts.getCommandLine1();
        String cli2 = opts.getCommandLine2();
        Long cli3 = opts.getCommandLine3();

        System.out.format("cli1 %s%n", cli1);
        System.out.format("cli2 %s%n", cli2);
        System.out.format("cli3 %d%n", cli3);

        MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
        

        // add player 1
        if (null != cli1) {
            gameRunner.addAgent(cli1);
        } else {
            gameRunner.addAgent("python C:/git/AzureDevOps/Training/CodingGame/PacMan/OtherBots/Boss.py", "Blinky",
                    "https://static.codingame.com/servlet/fileservlet?id=43829808065962");
        }

        // add player 2
        if (null != cli2) {
            gameRunner.addAgent(cli2);
        } else {
            gameRunner.addAgent("python C:/git/AzureDevOps/Training/CodingGame/PacMan/OtherBots/Boss.py", "Inky",
                    "https://static.codingame.com/servlet/fileservlet?id=43829821541064");
        }

        Long seed = 5842184981578562716L;
        if (null != cli3) {
            seed = cli3;
        }
        gameRunner.setSeed(seed);
        System.out.format("Seed %d%n", seed);

        Properties params = new Properties();

        gameRunner.setGameParameters(params);
        gameRunner.setLeagueLevel(3);

        gameRunner.start(8888);
    }
}

class Options {
    private String commandLine1 = null;
    private String commandLine2 = null;
    private String commandLine3 = null;

    public Options read(String[] args) {
        if (args == null) {
            return this;
        }

        switch (args.length) {
            case 1: {
                this.commandLine1 = args[0];
                break;
            }
            case 2: {
                this.commandLine1 = args[0];
                this.commandLine2 = args[1];
                break;
            }
            case 3: {
                this.commandLine1 = args[0];
                this.commandLine2 = args[1];
                this.commandLine3 = args[2];
                break;
            }
        }

        return this;
    }

    public String getCommandLine1() {
        return this.commandLine1;
    }

    public String getCommandLine2() {
        return this.commandLine2;
    }

    public Long getCommandLine3() {
        if(this.commandLine3 == null) return null;
        return Long.parseLong(this.commandLine3);
    }
}
