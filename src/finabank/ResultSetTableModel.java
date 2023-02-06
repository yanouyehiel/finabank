/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finabank;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yepy
 */
public class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    
    public ResultSetTableModel(ResultSet rs) {
        this.rs = rs;
        fireTableDataChanged();
    }
    
    public int getColumnCount() {
        try {
            if (rs == null) {
                return 0;
            }
            else {
                return rs.getMetaData().getColumnCount();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int getRowCount() {
        try {
            if (rs == null) {
                return 0;
            }
            else {
                rs.last();
                return rs.getRow();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex > getRowCount()
                || columnIndex < 0 || columnIndex > getColumnCount()) {
            return null;
        }
        try {
            if (rs == null) {
                return null;
            } else {
                rs.absolute(rowIndex + 1);
                return rs.getObject(columnIndex + 1);
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        try {
            return rs.getMetaData().getColumnName(columnIndex + 1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return super.getColumnName(columnIndex);
    }
}