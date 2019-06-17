package db_connection;

public class SQLCommands {
    public static String addPlayer = "INSERT INTO _players(id, name, position, age, height, weight\n" +
            "\t\t\t\t   , nationality, appearance)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static String updateD = "UPDATE D\n" +
            "SET " +
            " minutes = minutes + ?,\n" +
            " tackles = ((tackles * appearance) + ? ) / (appearance + 1),\n" +
            " inter = ((inter * appearance) + ? ) / (appearance + 1),\n" +
            " fouls = ((fouls * appearance) + ? ) / (appearance + 1),\n" +
            " offsides = ((offsides * appearance) + ? ) / (appearance + 1),\n" +
            " clear = ((clear * appearance) + ? ) / (appearance + 1),\n" +
            " drb = ((drb * appearance) + ? ) / (appearance + 1),\n" +
            " blocks = ((blocks * appearance) + ? ) / (appearance + 1),\n" +
            " owng = owng + ?,\n" +
            " rating = ((rating * appearance) + ? ) / (appearance + 1)\n" +
            " FROM _players" +
            " WHERE\n" +
            "   D.id= ? ;";
    public static String updateF = "UPDATE F\n" +
            "SET " +
            " minutes = minutes + ?,\n" +
            " goals = goals + ?,\n" +
            " assists = assists + ?,\n" +
            " spg = ((spg * appearance) + ? ) / (appearance + 1),\n" +
            " keyp = ((keyp * appearance) + ? ) / (appearance + 1),\n" +
            " drb = ((drb * appearance) + ? ) / (appearance + 1),\n" +
            " fouled = ((fouled * appearance) + ? ) / (appearance + 1),\n" +
            " off = ((off * appearance) + ? ) / (appearance + 1),\n" +
            " disp = ((disp * appearance) + ? ) / (appearance + 1),\n" +
            " unstch = ((unstch * appearance) + ? ) / (appearance + 1),\n" +
            " rating = ((rating * appearance) + ? ) / (appearance + 1)\n" +
            " FROM _players" +
            " WHERE\n" +
            "   F.id= ? ;";

    public static String updateM = "UPDATE M\n" +
            "SET " +
            " minutes = minutes + ?,\n" +
            " assists = assists + ?,\n" +
            " keyp = ((keyp * appearance) + ? ) / (appearance + 1),\n" +
            " avgp = ((avgp * appearance) + ? ) / (appearance + 1),\n" +
            " ps = ((ps * appearance) + ? ) / (appearance + 1),\n" +
            " crosses = ((crosses * appearance) + ? ) / (appearance + 1),\n" +
            " longb = ((longb * appearance) + ? ) / (appearance + 1),\n" +
            " thrb = ((thrb * appearance) + ? ) / (appearance + 1),\n" +
            " rating = ((rating * appearance) + ? ) / (appearance + 1)\n" +
            " FROM _players" +
            " WHERE\n" +
            "   M.id= ? ;";
    public static String updateG = "UPDATE G\n" +
            "SET " +
            " minutes = minutes + ?,\n" +
            " conceded = conceded + ?,\n" +
            " clean = clean + ?\n" +
            " WHERE\n" +
            "   id= ? ;";

    public static String deletePlayer = "DELETE FROM _players" +
            "\n WHERE id = ? ;";

    public static String loadPlayer = "SELECT * FROM _players";

    public static String loadG = "SELECT * FROM g  where id = ?";

    public static String loadD = "SELECT * FROM d  where id = ?";
    public static String loadM = "SELECT * FROM m  where id = ?";
    public static String loadF = "SELECT * FROM f  where id = ?";

    public static String loagImage = "SELECT url FROM pictures WHERE id = ?";

}
