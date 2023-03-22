package br.fiap.cp1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	protected Connection connection;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
}
