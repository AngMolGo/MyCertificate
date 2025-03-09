package com.mexiti.mycertificate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexiti.mycertificate.ui.theme.MyCertificateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCertificateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CertificatingCourse(
                        nombre = "José Ángel Molina González",
                        number = 5,
                        course = "Android desde cero",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/*
*   TODO:
*   ✓   Colocar dos escudos diferentes en el extremo izquierdo y derecho al inicio del certificado.
*   ✓  El tamaño de cada escudo debe de ser de 50 dp de ancho y alto.
*   ✓  En medio de los dos escudos debe de ir el nombre del departamento o empresa ficticia
*   ✓  En el  segundo renglón independiente debe mostrar el mensaje "This certificate is presented to:"
*   ✓  En un tercer renglón colocar tú nombre completo resaltado por negritas y de un tamaño de fuente mayor al anterior. El nombre deberá estar centrado con respecto a una imagen de Fondo que permita continuar resaltando el nombre.
*   ✓  En el cuarto renglón mostrar el texto: "has completed a #number hours course on" donde number es una variable que representa el número de horas.
*   ✓  En el quinto renglón colocar en una variable denominada course el nombre del curso por el cual se certifica
*   ✓  En el sexto renglón colocar los nombres y firmas de dos representantes de la empresa ficticia. Los nombres deberán de ir separados.
* */

@Composable
fun CertificatingCourse(nombre: String, number: Int, course: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // RENGLÓN 1: Dos escudos y nombre del departamento
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.universidad_patito),
                contentDescription = "Logo de Universidad Patito",
                modifier = Modifier.size(50.dp)
            )
            Text(text = "Universidad Nacional de\n   Aplicaciones Móviles")
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Logo de la UNAM",
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // RENGLÓN 2: Mensaje de presentación
        Text(text = "This certificate is presented to:")

        // RENGLÓN 3: Nombre con imagen de fondo
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_certificate),
                contentDescription = "Logo de Certificado",
                modifier = Modifier.fillMaxWidth(),
                alpha = 0.1F
            )
            Text(
                text = nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // RENGLÓN 4: Número de horas del curso
        Text(
            text = "has completed a $number hours course on",
            textAlign = TextAlign.Center
        )

        // RENGLÓN 5: Nombre del curso
        Text(
            text = "\"$course\"",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(60.dp))

        // RENGLÓN 6: Nombres y firmas de representantes
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.firma_john_doe),
                    contentDescription = "Firma de John Doe",
                    modifier = Modifier.width(160.dp)
                )
                Text(text = "John Doe", fontWeight = FontWeight.Bold)
                Text(text = "Director")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.firma_jane_smith),
                    contentDescription = "Logo de la Jane Smith",
                    modifier = Modifier.width(350.dp)
                )
                Text(text = "Jane Smith", fontWeight = FontWeight.Bold)
                Text(text = "Coordinadora del\n       programa")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CertificatingCoursePreview() {
    CertificatingCourse(
        nombre = "José Ángel Molina González",
        number = 3,
        course = "Android desde cero"
    )
}
