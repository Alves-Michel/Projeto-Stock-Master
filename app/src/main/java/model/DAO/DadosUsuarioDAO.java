package model.DAO;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import model.Conection;
import model.DadosUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DadosUsuarioDAO {

    private Context context;

    public DadosUsuarioDAO(Context context) {
        this.context = context;
    }

    Connection conn;

    public ResultSet autenticacaoUsuario(DadosUsuario objusuario){
        conn = new Conection().getConexao();

        try{
            String sql = "SELECT * FROM usuario where nomeUsuario = ? and senhaUsuario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuario.getLogin());
            pstm.setString(2, objusuario.getSenha());
            ResultSet rs = pstm.executeQuery();
            return rs;
        }

            catch (SQLException erro) {
                Log.e("UsuarioDAO", "Erro ao acessar banco de dados", erro);
                Toast.makeText(context, "Erro no UsuarioDAO: ", Toast.LENGTH_LONG).show();
                return null;
            }

        }





    public void CadastrarUsuario(DadosUsuario user){
        String sql = "INSERT INTO USUARIO (nomeUsuario, senhaUsuario ) VALUES (?, ?)";
        PreparedStatement ps = null;

        try {
            ps = Conection.getConexao().prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getSenha());
            ps.execute();
            ps.close();
            Toast.makeText(context, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        } catch (SQLException var5) {
            Log.e("UsuarioDAO", "Erro ao cadastrar usuário", var5);
            Toast.makeText(context, "Erro ao cadastrar usuário: " + var5.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}