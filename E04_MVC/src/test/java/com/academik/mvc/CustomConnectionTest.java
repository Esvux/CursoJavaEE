package com.academik.mvc;

import com.academik.mvc.utils.CustomConnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author esvin
 */
public class CustomConnectionTest {

    @Test
    public void testConnection() {
        Connection conn = null;
        try {
            conn = CustomConnection.getInstance().getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        Assert.assertNotNull(conn);
    }

}
