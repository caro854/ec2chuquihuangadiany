package pe.edu.idat.ec2_chuquihuanga_diany


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent()
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("AppIDAT") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue)
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.White)
            ) {
                FormContent()
            }
        }
    }
}

@Composable
fun DrawerContent() {
    // Drawer content can be added here
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(text = "Drawer Item 1")
        Text(text = "Drawer Item 2")
    }
}

@Composable
fun FormContent() {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var otroPrograma by remember { mutableStateOf("") }

    var msSqlServer by remember { mutableStateOf(false) }
    var vStudioCode by remember { mutableStateOf(false) }
    var androidStudio by remember { mutableStateOf(false) }
    var otro by remember { mutableStateOf(false) }

    var colorFavorito by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("INFORMACIÓN", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = apellidos,
            onValueChange = { apellidos = it },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = dni,
            onValueChange = { dni = it },
            label = { Text("DNI") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = celular,
            onValueChange = { celular = it },
            label = { Text("Celular") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Text("Seleccione Programas que domine:", modifier = Modifier.padding(vertical = 8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Checkbox(checked = msSqlServer, onCheckedChange = { msSqlServer = it })
            Text("MS SQL Server")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Checkbox(checked = vStudioCode, onCheckedChange = { vStudioCode = it })
            Text("VStudioCode")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Checkbox(checked = androidStudio, onCheckedChange = { androidStudio = it })
            Text("Android Studio")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Checkbox(checked = otro, onCheckedChange = { otro = it })
            Text("Otro")
        }
        OutlinedTextField(
            value = otroPrograma,
            onValueChange = { otroPrograma = it },
            label = { Text("Ingrese otro programa") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Text("Seleccione su color favorito:", modifier = Modifier.padding(vertical = 8.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = colorFavorito == "Azul",
                    onClick = { colorFavorito = "Azul" }
                )
                Text("Azul")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = colorFavorito == "Rojo",
                    onClick = { colorFavorito = "Rojo" }
                )
                Text("Rojo")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = colorFavorito == "Verde",
                    onClick = { colorFavorito = "Verde" }
                )
                Text("Verde")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = colorFavorito == "Otro",
                    onClick = { colorFavorito = "Otro" }
                )
                Text("Otro")
            }
        }

        Button(onClick = { /* Handle the form submission */ }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Acceder")
        }
    }
}