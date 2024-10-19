package ru.nsu.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.business_card.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding),
                        personData = Data.personData,
                        contactData = Data.contactData
                    )
                }
            }
        }
    }
}

// Чтобы не копипастить эти данные для превью
object Data {
    val personData = PersonDataClass(
        name = "Alexey Malov",
        job = "Junior Android Dev",
        imageId = R.drawable.ic_launcher_foreground
    )
    val contactData = ContactDataClass(
        mobilePhone = "+79138905892", email = "alexkkk@inbox.ru", nickName = "L3XxXa"
    )

}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier, personData: PersonDataClass, contactData: ContactDataClass
) {
    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonData(personData, modifier)
        ContactData(contactData, modifier)
    }
}

@Composable
fun PersonData(
    peronData: PersonDataClass, modifier: Modifier = Modifier
) {
    val image = painterResource(peronData.imageId)
    Column(
        modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image, contentDescription = "Person image"
        )
        Text(
            text = peronData.name, fontSize = 30.sp, textAlign = TextAlign.Center
        )
        Text(
            text = peronData.job,
            color = Color(0xFF3ddc84),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactData(
    contactData: ContactDataClass, modifier: Modifier = Modifier
) {
    Column(
        modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactDataRow(contactData.mobilePhone ?: "", Icons.Rounded.Call, "Mobile phone")
        ContactDataRow(contactData.email ?: "", Icons.Rounded.Email, "Email")
        ContactDataRow("@${contactData.nickName}", Icons.Rounded.Share, "Nickname")
    }
}

@Composable
fun ContactDataRow(data: String, icon: ImageVector, contentDescription: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        Icon(
            imageVector = icon, contentDescription = contentDescription
        )
        Text(
            text = data, textAlign = TextAlign.Center
        )
    }
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            BusinessCard(
                modifier = Modifier.padding(innerPadding),
                personData = Data.personData,
                contactData = Data.contactData
            )
        }
    }
}

data class PersonDataClass(
    val name: String,
    val job: String,
    val imageId: Int,
)

data class ContactDataClass(
    val mobilePhone: String? = null, val nickName: String? = null, val email: String? = null
)