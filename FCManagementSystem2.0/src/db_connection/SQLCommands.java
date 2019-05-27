package db_connection;

public class SQLCommands {
    public static String addPlayer = "INSERT INTO _players(id, name, position, age, height, weight\n" +
            "\t\t\t\t   , nationality, appearance)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static String loadPlayer = "SELECT * FROM _players";

    public static String loadG = "SELECT * FROM g  where id = ?";

    public static String loadD = "SELECT * FROM d  where id = ?";
    public static String loadM = "SELECT * FROM m  where id = ?";
    public static String loadF = "SELECT * FROM f  where id = ?";

    public static String loagImage = "SELECT url FROM pictures WHERE id = ?";

}
