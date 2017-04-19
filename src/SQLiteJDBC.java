import java.sql.*;

public class SQLiteJDBC
{
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:heroes.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            // select statement
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM NEWHEROES;" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String title = rs.getString("TITLE");
                String role1 = rs.getString("ROLE_1");
                String role2 = rs.getString("ROLE_2");
                float health = rs.getFloat("HEALTH");
                float health_regen = rs.getFloat("HEALTH_REGEN");
                float mana = rs.getFloat("MANA");
                float mana_regen = rs.getFloat("MANA_REGEN");
                float movement_speed = rs.getFloat("MOVEMENT_SPEED");
                float attack_damage = rs.getFloat("ATTACK_DAMAGE");
                float attack_speed = rs.getFloat("ATTACK_SPEED");
                float attack_range = rs.getFloat("ATTACK_RANGE");
                float armor = rs.getFloat("ARMOR");
                float magic_resist = rs.getFloat("MAGIC_RESIST");


                System.out.println( "ID = " + id);
                System.out.println( "NAME = " + name);
                System.out.println( "TITLE = " + title);
                System.out.println( "ROLE_1 = " + role1);
                System.out.println( "ROLE_2 = " + role2);
                System.out.println( "HEALTH = " + health);
                System.out.println( "HEALTH_REGEN = " + health_regen);
                System.out.println( "MANA = " + mana);
                System.out.println( "MANA_REGEN = " + mana_regen);
                System.out.println( "MOVEMENT_SPEED = " + movement_speed);
                System.out.println( "ATTACK_DAMAGE = " + attack_damage);
                System.out.println( "ATTACK_SPEED = " + attack_speed);
                System.out.println( "ATTACK_RANGE = " + attack_range);
                System.out.println( "ARMOR = " + armor);
                System.out.println( "MAGIC_RESIST = " + magic_resist);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}

            // create statement
/*            stmt = c.createStatement();
            String sql = "CREATE TABLE NEWHEROES " +
                    "(ID INT  PRIMARY KEY    NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " TITLE          TEXT    NOT NULL, " +
                    " ROLE_1         TEXT    NOT NULL, " +
                    " ROLE_2         TEXT    NOT NULL, " +
                    " HEALTH         REAL    NOT NULL, " +
                    " HEALTH_REGEN   REAL    NOT NULL, " +
                    " MANA           REAL    NOT NULL, " +
                    " MANA_REGEN     REAL    NOT NULL, " +
                    " MOVEMENT_SPEED REAL    NOT NULL, " +
                    " ATTACK_DAMAGE  REAL    NOT NULL, " +
                    " ATTACK_SPEED   REAL    NOT NULL, " +
                    " ATTACK_RANGE   REAL    NOT NULL, " +
                    " ARMOR          REAL    NOT NULL, " +
                    " MAGIC_RESIST   REAL    NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}*/


            // insert statements
/*           sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, "
                    + "HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (133, 'Quinn', 'the Demacia''s Wings', 'Marksman', 'Fighter', 617.8, 5.974, 303.8, 7.372, 335, 56.87, 0.668, 525, 26.88, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (25, 'Morgana', 'the Fallen Angel', 'Mage', 'Support', 633.48, 6.308, 400.8, 9.3, 335, 58.96, 0.625, 450, 29.184, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (24, 'Jax', 'the Grandmaster at Arms', 'Fighter', 'Assassin', 677.8, 8.924, 370.8, 8.276, 350, 65.345, 0.638, 125, 30.04, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (78, 'Poppy', 'the Keeper of the Hammer', 'Tank', 'Fighter', 630, 8.8, 320, 7.7, 345, 60, 0.625, 125, 32.5, 33.25);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (37, 'Sona', 'the Maven of the Strings', 'Support', 'Mage', 559.36, 5.974, 385.6, 11.9, 325, 53.04, 0.644, 550, 23.844, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (143, 'Zyra', 'the Rise of the Thorns', 'Mage', 'Support', 573.32, 6.19, 384, 9.3, 340, 56.576, 0.625, 575, 23.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (131, 'Diana', 'the Scorn of the Moon', 'Fighter', 'Mage', 679.2, 8.278, 337.2, 6.8, 345, 56.04, 0.625, 150, 29.648, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (54, 'Malphite', 'the Shard of the Monolith', 'Tank', 'Fighter', 664.2, 7.55, 322.2, 7.874, 335, 65.345, 0.638, 125, 32.05, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (83, 'Yorick', 'the Shepherd of Souls', 'Fighter', 'Tank', 680, 8.8, 340, 8.25, 340, 62, 0.625, 175, 34, 33.25);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (33, 'Rammus', 'the Armordillo', 'Tank', 'Fighter', 650.48, 8.474, 343.44, 8.34, 335, 59.38, 0.625, 125, 35.684, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (110, 'Varus', 'the Arrow of Retribution', 'Marksman', 'Mage', 619.76, 5.974, 393.48, 8.14, 330, 57.07, 0.658, 575, 26.612, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (80, 'Pantheon', 'the Artisan of War', 'Fighter', 'Assassin', 666.16, 8.492, 348.12, 7.806, 355, 58.472, 0.644, 150, 31.552, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (23, 'Tryndamere', 'the Barbarian King', 'Fighter', 'Assassin', 723.64, 9.412, 100, 0, 345, 64.576, 0.67, 125, 27.208, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (15, 'Sivir', 'the Battle Mistress', 'Marksman', '', 597.76, 5.724, 334, 8.912, 335, 59.87, 0.625, 500, 25.46, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (2, 'Olaf', 'the Berserker', 'Fighter', 'Tank', 690.24, 9.412, 357.6, 8.041, 350, 63.48, 0.694, 125, 29.04, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (76, 'Nidalee', 'the Bestial Huntress', 'Assassin', 'Fighter', 620, 6.608, 340.6, 6.8, 335, 56.5, 0.638, 525, 26.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (91, 'Talon', 'the Blade''s Shadow', 'Assassin', 'Fighter', 673, 9.26, 414.2, 8.4, 335, 63.1, 0.668, 125, 30.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (64, 'Lee Sin', 'the Blind Monk', 'Fighter', 'Assassin', 655.8, 8.126, 200, 50, 350, 64.376, 0.651, 125, 27.916, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (21, 'Miss Fortune', 'the Bounty Hunter', 'Marksman', '', 615, 6.842, 360.84, 8.692, 325, 47, 0.656, 550, 27.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (245, 'Ekko', 'the Boy Who Shattered Time', 'Assassin', 'Fighter', 660, 9.9, 330, 7.8, 340, 58, 0.625, 125, 30, 33.25);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (63, 'Brand', 'the Burning Vengeance', 'Mage', '', 583.68, 5.974, 417.6, 8.608, 340, 60.04, 0.625, 550, 25.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (58, 'Renekton', 'the Butcher of the Sands', 'Fighter', 'Tank', 659.16, 8.71, 100, 0, 345, 61.428, 0.665, 125, 29.384, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (240, 'Kled', 'the Cantankerous Cavalier', 'Fighter', 'Tank', 410, 6.75, 100, 0, 345, 58, 0.625, 125, 30, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (4, 'Twisted Fate', 'the Card Master', 'Mage', '', 603.76, 6.108, 303.84, 6.8, 330, 53.254, 0.651, 525, 23.692, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (412, 'Thresh', 'the Chain Warden', 'Support', 'Fighter', 653.52, 7.474, 317.92, 6.8, 335, 49.896, 0.625, 450, 16, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (26, 'Zilean', 'the Chronokeeper', 'Support', 'Mage', 576.28, 5.94, 420.8, 9.3, 335, 54.64, 0.625, 550, 22.934, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (8, 'Vladimir', 'the Crimson Reaper', 'Mage', 'Tank', 609, 7.608, 2, 0, 330, 58, 0.658, 450, 26.3, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (34, 'Anivia', 'the Cryophoenix', 'Mage', 'Support', 537.6, 6.124, 446.04, 6.8, 325, 54.576, 0.625, 600, 25.22, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (72, 'Skarner', 'the Crystal Vanguard', 'Fighter', 'Tank', 691.28, 9.778, 312.2, 7.656, 335, 61.656, 0.625, 125, 33.184, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (75, 'Nasus', 'the Curator of the Sands', 'Fighter', 'Tank', 651.2, 9.912, 367.6, 7.94, 350, 62.68, 0.638, 125, 28.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (42, 'Corki', 'the Daring Bombardier', 'Marksman', '', 594.76, 5.974, 384.16, 7.974, 325, 59.5, 0.625, 550, 26.88, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (1, 'Annie', 'the Dark Child', 'Mage', '', 587.68, 5.974, 384, 6.8, 335, 53.035, 0.579, 575, 23.22, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (134, 'Syndra', 'the Dark Sovereign', 'Mage', 'Support', 589.04, 7.108, 444, 6.8, 330, 56.772, 0.625, 550, 28.112, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (266, 'Aatrox', 'the Darkin Blade', 'Fighter', 'Tank', 622.8, 7.09, 100, 0, 345, 63.576, 0.651, 150, 28.184, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (30, 'Karthus', 'the Deathsinger', 'Mage', '', 591, 6.974, 433.48, 6.8, 335, 48.91, 0.625, 450, 24.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (7, 'LeBlanc', 'the Deceiver', 'Assassin', 'Mage', 596, 7.95, 384, 6.8, 340, 58.38, 0.625, 525, 25.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (126, 'Jayce', 'the Defender of Tomorrow', 'Fighter', 'Marksman', 661.2, 8.144, 394.2, 6.8, 335, 53.88, 0.658, 125, 25.88, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (35, 'Shaco', 'the Demon Jester', 'Assassin', '', 666.12, 8.924, 337.2, 7.606, 350, 61.08, 0.694, 125, 28.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (268, 'Azir', 'the Emperor of the Sands', 'Mage', 'Marksman', 604.4, 7.474, 392.56, 6.8, 325, 54.8, 0.638, 525, 22.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (43, 'Karma', 'the Enlightened One', 'Mage', 'Support', 605.44, 6.174, 424, 9.3, 335, 56.844, 0.625, 525, 24.184, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (203, 'Kindred', 'the Eternal Hunters', 'Marksman', '', 625, 7.55, 335, 7.372, 325, 55.7, 0.625, 500, 23.5, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (56, 'Nocturne', 'the Eternal Nightmare', 'Assassin', 'Fighter', 667.8, 9.01, 308.8, 7.206, 345, 62.308, 0.668, 125, 30.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (59, 'Jarvan IV', 'the Exemplar of Demacia', 'Tank', 'Fighter', 661.2, 8.876, 342.2, 7.206, 340, 59.112, 0.658, 175, 32.6, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (92, 'Riven', 'the Exile', 'Fighter', 'Assassin', 644.48, 5.84, 0, 0, 340, 59.04, 0.625, 125, 27.576, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (161, 'Vel''Koz', 'the Eye of the Void', 'Mage', '', 583.68, 5.974, 417.6, 6.8, 340, 58.0795, 0.625, 525, 25.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (98, 'Shen', 'the Eye of Twilight', 'Tank', 'elee', 625, 9.25, 400, 50, 340, 63, 0.625, 125, 28, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (117, 'Lulu', 'the Fae Sorceress', 'Support', 'Mage', 626.76, 6.608, 405, 11.6, 330, 48.968, 0.625, 550, 22.916, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (84, 'Akali', 'the Fist of Shadow', 'Assassin', '', 672.8, 8.992, 200, 50, 350, 61.576, 0.694, 125, 29.88, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (22, 'Ashe', 'the Frost Archer', 'Marksman', 'Support', 606.72, 5.974, 312, 7.372, 325, 58.768, 0.658, 600, 24.612, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (119, 'Draven', 'the Glorious Executioner', 'Marksman', '', 639.76, 6.876, 399.56, 8.692, 330, 58.71, 0.679, 550, 28.844, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (114, 'Fiora', 'the Grand Duelist', 'Fighter', 'Assassin', 635, 8.8, 340, 8.7, 345, 63.3, 0.625, 150, 27.5, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (53, 'Blitzcrank', 'the Great Steam Golem', 'Tank', 'Fighter', 677.6, 9.26, 307.2, 9.3, 325, 65.04, 0.625, 125, 28.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (427, 'Ivern', 'the Green Father', 'Support', 'Mage', 670, 7.75, 510, 6.75, 330, 53, 0.644, 125, 25.5, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (102, 'Shyvana', 'the Half-Dragon', 'Fighter', 'Tank', 690, 9.4, 100, 0, 350, 64.112, 0.658, 125, 30.978, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (122, 'Darius', 'the Hand of Noxus', 'Fighter', 'Tank', 682.24, 10.796, 300.5, 6.938, 340, 61, 0.625, 175, 34, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (9, 'Fiddlesticks', 'the Harbinger of Doom', 'Mage', 'Support', 604.4, 6.208, 456.12, 6.8, 335, 50.985, 0.625, 480, 24.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (6, 'Urgot', 'the Headsman''s Pride', 'Marksman', 'Fighter', 675.52, 7.108, 367.4, 9.242, 335, 57.65, 0.644, 425, 27.844, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (201, 'Braum', 'the Heart of the Freljord', 'Support', 'Tank', 663.16, 9.18, 355.6, 6.8, 335, 58.576, 0.644, 125, 31.22, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (85, 'Kennen', 'the Heart of the Tempest', 'Mage', 'Marksman', 614.72, 6.242, 200, 50, 335, 53.844, 0.69, 550, 28.05, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (115, 'Ziggs', 'the Hexplosives Expert', 'Mage', '', 604.4, 6.858, 431, 6.8, 325, 57.308, 0.656, 550, 24.844, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (127, 'Lissandra', 'the Ice Witch', 'Mage', '', 581.12, 7.474, 354, 6.072, 325, 53.236, 0.625, 550, 23.916, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (82, 'Mordekaiser', 'the Iron Revenant', 'Fighter', '', 598, 4.3, 0, 0, 325, 66, 0.601, 175, 23.75, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (10, 'Kayle', 'the Judicator', 'Fighter', 'Support', 667.24, 9.01, 362.2, 6.8, 335, 53.8, 0.638, 125, 30.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (420, 'Illaoi', 'the Kraken Priestess', 'Fighter', 'Tank', 680.6, 10.3, 340, 8.25, 340, 65, 0.625, 125, 29.8, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (61, 'Orianna', 'the Lady of Clockwork', 'Mage', 'Support', 596.72, 7.424, 384, 6.8, 325, 42.968, 0.658, 525, 20.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (99, 'Lux', 'the Lady of Luminosity', 'Mage', 'Support', 556.72, 5.974, 431, 6.8, 330, 56.844, 0.625, 550, 22.72, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (222, 'Jinx', 'the Loose Cannon', 'Marksman', '', 599.76, 6.34, 290.6, 7.68, 325, 60.87, 0.625, 525, 26.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (112, 'Viktor', 'the Machine Herald', 'Mage', '', 594.04, 8.492, 374, 6.8, 335, 55.04, 0.658, 525, 26.72, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (27, 'Singed', 'the Mad Chemist', 'Tank', 'Fighter', 624.76, 8.574, 335.6, 8.074, 345, 65.695, 0.613, 125, 31.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (36, 'Dr. Mundo', 'the Madman of Zaun', 'Fighter', 'Tank', 671.52, 8.51, 0, 0, 345, 64.27, 0.625, 125, 30.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (101, 'Xerath', 'the Magus Ascendant', 'Mage', 'Assassin', 594.4, 5.974, 410.96, 6.8, 340, 57.7, 0.625, 525, 25.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (238, 'Zed', 'the Master of Shadows', 'Assassin', 'Fighter', 659.4, 7.742, 200, 50, 345, 58.112, 0.644, 125, 30.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (50, 'Swain', 'the Master Tactician', 'Mage', 'Fighter', 606.04, 8.492, 421, 6.8, 335, 55.04, 0.625, 500, 26.72, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (68, 'Rumble', 'the Mechanized Menace', 'Fighter', 'Mage', 664.4, 8.608, 100, 0, 345, 64.236, 0.644, 125, 29.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (86, 'Garen', 'the Might of Demacia', 'Fighter', 'Tank', 700.53, 8.34, 0, 0, 340, 62.38, 0.625, 175, 30.536, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (12, 'Alistar', 'the Minotaur', 'Tank', 'Support', 719.36, 9.528, 316.84, 9.3, 330, 64.7316, 0.625, 125, 27.88, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (150, 'Gnar', 'the Missing Link', 'Fighter', 'Tank', 605, 3, 100, 0, 325, 54, 0.625, 175, 25.5, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (62, 'Wukong', 'the Monkey King', 'Fighter', 'Tank', 662.8, 6.842, 303.84, 8.692, 345, 63.076, 0.658, 175, 28.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (96, 'Kog''Maw', 'the Mouth of the Abyss', 'Marksman', 'Mage', 599.76, 6.474, 362.2, 9.376, 325, 59.87, 0.665, 500, 23.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (67, 'Vayne', 'the Night Hunter', 'Marksman', 'Assassin', 581.44, 5.974, 266.8, 7.372, 330, 57.54, 0.658, 550, 22.412, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (103, 'Ahri', 'the Nine-Tailed Fox', 'Mage', 'Assassin', 594.4, 7.108, 384, 6.8, 330, 56.04, 0.668, 550, 24.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (104, 'Graves', 'the Outlaw', 'Marksman', '', 635.12, 7.376, 362.2, 8.6, 340, 63.24, 0.481, 425, 27.776, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (254, 'Vi', 'the Piltover Enforcer', 'Fighter', 'Assassin', 667.8, 9.912, 340.6, 8.742, 340, 59.38, 0.625, 125, 29.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (29, 'Twitch', 'the Plague Rat', 'Marksman', 'Assassin', 606.08, 6.608, 327.2, 7.706, 330, 57.87, 0.679, 550, 26.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (107, 'Rengar', 'the Pridestalker', 'Assassin', 'Fighter', 676.2, 7.5, 4, 0, 345, 61.5, 0.625, 125, 25, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (81, 'Ezreal', 'the Prodigal Explorer', 'Marksman', 'Mage', 564.4, 6.974, 402.6, 8.742, 325, 58.07, 0.625, 550, 25.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (90, 'Malzahar', 'the Prophet of the Void', 'Mage', 'Assassin', 600, 6.6, 355, 6.8, 335, 58, 0.625, 500, 23.5, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (236, 'Lucian', 'the Purifier', 'Marksman', '', 634.4, 6.842, 386.88, 8.876, 335, 59.87, 0.638, 500, 27.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (79, 'Gragas', 'the Rabble Rouser', 'Fighter', 'Mage', 672.52, 6, 447, 6.8, 330, 64.88, 0.651, 125, 32.65, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (89, 'Leona', 'the Radiant Dawn', 'Tank', 'Support', 663.16, 9.278, 342.2, 6.8, 335, 63.04, 0.625, 125, 30.808, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (74, 'Heimerdinger', 'the Revered Inventor', 'Mage', 'Support', 551, 12.758, 347.2, 6.8, 340, 58.236, 0.625, 550, 22.04, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (223, 'Tahm Kench', 'the River King', 'Support', 'Tank', 705, 7.05, 365, 9, 335, 59.2, 0.625, 175, 30.5, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (13, 'Ryze', 'the Rune Mage', 'Mage', 'Fighter', 644.48, 7.55, 450, 6.8, 340, 58.04, 0.625, 550, 24.552, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (32, 'Amumu', 'the Sad Mummy', 'Tank', 'Mage', 697.12, 9.728, 327.2, 7.907, 335, 57.184, 0.638, 125, 27.344, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (41, 'Gangplank', 'the Saltwater Scourge', 'Fighter', '', 622, 6.6, 322, 8.2, 345, 59, 0.625, 125, 29, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (154, 'Zac', 'the Secret Weapon', 'Tank', 'Fighter', 709.6, 8.474, 0, 0, 340, 63.045, 0.638, 175, 27.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (5, 'Xin Zhao', 'the Seneschal of Demacia', 'Fighter', 'Assassin', 692, 8.876, 308.8, 7.706, 345, 60.844, 0.625, 175, 29.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (3, 'Galio', 'the Sentinel''s Sorrow', 'Tank', 'Mage', 662.8, 9.46, 416, 6.8, 335, 65.345, 0.638, 125, 30.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (69, 'Cassiopeia', 'the Serpent''s Embrace', 'Mage', '', 600, 6, 435, 6.8, 328, 56, 0.647, 550, 28.5, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (120, 'Hecarim', 'the Shadow of War', 'Fighter', 'Tank', 670, 7.75, 317.2, 7.1, 345, 61.2, 0.67, 175, 30.72, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (51, 'Caitlyn', 'the Sheriff of Piltover', 'Marksman', '', 604.4, 6.224, 348.7, 7.95, 325, 55.84, 0.568, 650, 26.38, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (44, 'Taric', 'the Shield of Valoran', 'Support', 'Fighter', 665, 6.5, 360, 6, 340, 58.5, 0.625, 150, 28.4, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (55, 'Katarina', 'the Sinister Blade', 'Assassin', 'Mage', 672, 8.2, 0, 0, 340, 61.2, 0.658, 125, 31.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (429, 'Kalista', 'the Spear of Vengeance', 'Marksman', '', 600.76, 6.55, 266.8, 6.7, 325, 65.9, 0.644, 550, 22.512, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (60, 'Elise', 'the Spider Queen', 'Mage', 'Fighter', 609.4, 6.308, 374, 6.8, 325, 53.54, 0.625, 550, 25.478, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (77, 'Udyr', 'the Spirit Walker', 'Fighter', 'Tank', 692.32, 6.75, 300.4, 7.956, 345, 61.486, 0.658, 125, 29.47, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (136, 'Aurelion Sol', 'the Star Forger', 'Mage', 'Fighter', 630, 7.1, 400, 6.8, 325, 60.2, 0.625, 550, 22.6, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (16, 'Soraka', 'the Starchild', 'Support', 'Mage', 607.04, 3, 410.8, 11.9, 325, 53.04, 0.625, 550, 27.184, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (164, 'Camille', 'the Steel Shadow', 'Fighter', 'Tank', 660.6, 9.3, 370.8, 8.9, 340, 63.5, 0.625, 125, 29.8, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (163, 'Taliyah', 'the Stoneweaver', 'Mage', 'Support', 595, 7.7, 400, 7.85, 325, 59.3, 0.625, 525, 23, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (40, 'Janna', 'the Storm''s Fury', 'Support', 'Mage', 565.04, 5.974, 473.52, 11.9, 335, 54.906, 0.625, 475, 23.184, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (17, 'Teemo', 'the Swift Scout', 'Marksman', 'Assassin', 597.76, 6.392, 307.2, 7.656, 330, 52.54, 0.69, 500, 28.05, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (31, 'Cho''Gath', 'the Terror of the Void', 'Tank', 'Mage', 654.4, 9.778, 312.2, 7.656, 345, 65.356, 0.625, 125, 32.38, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (106, 'Volibear', 'the Thunder''s Roar', 'Fighter', 'Tank', 670.48, 8.742, 300.4, 8.742, 345, 62.844, 0.658, 125, 29.88, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (105, 'Fizz', 'the Tidal Trickster', 'Assassin', 'Fighter', 644.48, 8.876, 354.2, 6.8, 335, 61.04, 0.658, 175, 25.812, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (267, 'Nami', 'the Tidecaller', 'Support', 'Mage', 563.32, 5.974, 420.24, 11.9, 335, 54.308, 0.644, 550, 23.72, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (45, 'Veigar', 'the Tiny Master of Evil', 'Mage', '', 574.76, 5.974, 444.4, 6.8, 340, 53.335, 0.625, 525, 26.3, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (111, 'Nautilus', 'the Titan of the Depths', 'Tank', 'Fighter', 662.48, 8.924, 381, 9.326, 325, 60.844, 0.613, 175, 30.21, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (48, 'Trundle', 'the Troll King', 'Fighter', 'Tank', 712.28, 6.75, 326.6, 8.108, 350, 63.04, 0.67, 175, 30.236, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (57, 'Maokai', 'the Twisted Treant', 'Tank', 'Mage', 662.2, 7.75, 420.28, 7.656, 335, 66.844, 0.694, 125, 32.72, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (19, 'Warwick', 'the Uncaged Wrath of Zaun', 'Fighter', 'Tank', 635, 4.5, 315, 8.041, 335, 61, 0.638, 125, 27.24, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (14, 'Sion', 'the Undead Juggernaut', 'Tank', 'Fighter', 615.64, 10.98, 367.6, 8.608, 345, 63.72, 0.679, 175, 26.04, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (157, 'Yasuo', 'the Unforgiven', 'Fighter', 'Assassin', 599.76, 7.412, 100, 0, 345, 58.576, 0.67, 175, 28.112, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (202, 'Jhin', 'the Virtuoso', 'Marksman', 'Assassin', 625, 6.55, 350, 6.8, 330, 57, 0.625, 550, 23.5, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (421, 'Rek''Sai', 'the Void Burrower', 'Fighter', '', 660, 7.992, 100, 0, 335, 58.978, 0.625, 175, 27.4, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (38, 'Kassadin', 'the Void Walker', 'Assassin', 'Mage', 642.04, 8.29, 464.6, 6.8, 340, 62.752, 0.64, 150, 26.576, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (121, 'Kha''Zix', 'the Voidreaver', 'Assassin', 'Fighter', 657.8, 8.26, 367.2, 8.09, 350, 58.31, 0.668, 125, 30, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (432, 'Bard', 'the Wandering Caretaker', 'Support', 'Mage', 624, 5.95, 400, 6.45, 330, 55, 0.625, 500, 29, 30);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (28, 'Evelynn', 'the Widowmaker', 'Assassin', 'Mage', 621.2, 10.374, 357.6, 8.708, 340, 57.38, 0.625, 125, 30.3, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (39, 'Irelia', 'the Will of the Blades', 'Fighter', 'Assassin', 697.2, 9.242, 370.8, 8.75, 345, 64.844, 0.665, 125, 29.05, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (113, 'Sejuani', 'the Winter''s Wrath', 'Tank', 'Fighter', 695, 9.528, 440, 7.656, 340, 60.844, 0.67, 125, 32.54, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (11, 'Master Yi', 'the Wuju Bladesman', 'Assassin', 'Fighter', 690.56, 8.242, 292.56, 7.706, 355, 63.04, 0.679, 125, 27.04, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (20, 'Nunu', 'the Yeti Rider', 'Support', 'Fighter', 688.28, 9.194, 325.56, 7.94, 350, 63, 0.625, 125, 29.88, 33.35);"; stmt.executeUpdate(sql);
            sql = "INSERT INTO NEWHEROES (ID, NAME, TITLE, ROLE_1, ROLE_2, HEALTH, HEALTH_REGEN, MANA, MANA_REGEN, MOVEMENT_SPEED, ATTACK_DAMAGE, ATTACK_SPEED, ATTACK_RANGE, ARMOR, MAGIC_RESIST)  VALUES (18, 'Tristana', 'the Yordle Gunner', 'Marksman', 'Assassin', 624.76, 6.842, 278.76, 7.656, 325, 59.37, 0.656, 550, 25, 30);"; stmt.executeUpdate(sql);





            // two tests
//            stmt = c.createStatement();
//            String sql = "INSERT INTO HEROES (ID,NAME,ROLE,HEALTH,"
//                    + "ATTACK_DAMAGE, ATTACK_SPEED, MOVEMENT_SPEED, "
//                    + "HEALTH_REGEN, ARMOR, MAGIC_RESIST) " +
//                    "VALUES (0, 'Myron', 'GodMode', 10000000, 10000000, "
//                    + "10000000, 10000000, 10000000, 10000000, "
//                    + "10000000);";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO HEROES (ID,NAME,ROLE,HEALTH,"
//                    + "ATTACK_DAMAGE, ATTACK_SPEED, MOVEMENT_SPEED, "
//                    + "HEALTH_REGEN, ARMOR, MAGIC_RESIST) " +
//                    "VALUES (1, 'Jian', 'GodMode', 10000000, 10000000, "
//                    + "10000000, 10000000, 10000000, 10000000, "
//                    + "10000000);";
//            stmt.executeUpdate(sql);
//
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
*/
