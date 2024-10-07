package com.example.stockmaster11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import model.DAO.DadosUsuarioDAO;
import model.DadosUsuario;

import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {

    Button entrar;
    private EditText loginEditText;
    private EditText senhaEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = findViewById(R.id.editTextTextLogin);
        senhaEditText = findViewById(R.id.editTextTextPasswordSenha);
        entrar = findViewById(R.id.buttonEntrar);
       DadosUsuarioDAO usuarioDAO = new DadosUsuarioDAO(this);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = loginEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                DadosUsuario usuario = new DadosUsuario(login,senha);
                usuario.setLogin(login);
                usuario.setSenha(senha);

                ResultSet resultUsuarioDao = usuarioDAO.autenticacaoUsuario(usuario);
               try {
                   if(resultUsuarioDao != null && resultUsuarioDao.next()){
                       Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                       startActivity(intent);

                   }else{
                       Toast.makeText(MainActivity.this,"Usuário ou Senha inválidos! ",Toast.LENGTH_SHORT).show();
                   }
               }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erro ao autenticar: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}