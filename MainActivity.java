ackage cl.ipchile.kt5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
    android.widget.EditText edtUsuario, edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario=findViewById(R.id.edtUsuario);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);

        ((View) btnLogin).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                validarUsuario("http://192.168.10.5/servicios/validar_usuario.php");
            }
        });
    }
    private void validarUsuario(String URL)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent=new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Usuario Incorrecto" ,Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener (){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString()+"Error en el desarrollo del codigo" ,Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map <String, String>getParams() throws AuthFailureError{
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("usuario", edtUsuario.getText().toString());
                parametros.put("usuario", edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}