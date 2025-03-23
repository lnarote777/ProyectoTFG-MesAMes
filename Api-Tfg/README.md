# 📅 Api Mes A Mes

## 📜 Descripción
La API "Mes A Mes" permite a los usuarios llevar un **seguimiento detallado de su ciclo menstrual**.

Además, ofrece funcionalidades como:
+ Registro y gestión de usuarios.
+ Seguimiento diario del ciclo. 
+ Listado de síntomas y estados emocionales predefinidos.
+ Configuración de preferencias y recordatorios.

### 🛠️ **Tecnologías Utilizadas**
- **Backend:** Kotlin, Spring Boot
- **Base de Datos:** MongoDB
- **Autenticación:** JWT

---

## 📂 **Estructura de la Base de Datos**

### 🏷️ **Usuarios**
| Campo            | Tipo          | Descripción                                         |
|------------------|---------------|-----------------------------------------------------|
| `id`             | String        | Identificador único, correo electróico del usuario. |
| `nombre`         | String        | Nombre del usuario                                  |
| `username`       | String        | Nombre de usuario                                   |
| `password`       | String (hash) | Contraseña encriptada                               |
| `fecha_registro` | Date          | Fecha en la que se registró                         |

### 📆 **SeguimientoDiario**
| Campo              | Tipo       | Descripción                                            |
|--------------------|------------|--------------------------------------------------------|
| `id`               | Int        | ID único del seguimiento                               |
| `usuario`          | Usuario    | Usuario que realiza el seguimiento                     |
| `fecha`            | Date       | Fecha del seguimiento                                  |
| `fase_ciclo`       | String     | Fase del ciclo (Menstruación, Ovulación, etc.)         |
| `flujo_menstrual`  | String     | Intensidad del flujo                                   |
| `actividad_fisica` | String     | Actividad física realizada                             |
| `sintomas`         | JSON       | Lista de síntomas registrados                          |
| `sentimientos`     | JSON       | Lista de estados emocionales                           |
| `notas`            | String     | Notas opcionales                                       |

### 💠 **Otras Tablas Relacionadas**
- `fases_ciclo`: Contiene las distintas fases del ciclo.
- `sintomas`: Lista de síntomas predefinidos.
- `sentimientos`: Lista de estados emocionales predefinidos.
- `flujo_menstrual`: Tipos de flujo (Leve, Moderado, Abundante, etc.).

---

## 📡 **Endpoints de la API**

### **👤 Usuarios**
| Método   | Endpoint               | Descripción                             |
|----------|------------------------|-----------------------------------------|
| `GET`    | `/api/usuarios/{id}`   | Obtiene un usuario por su ID.           |
| `POST`   | `/api/registrar`       | Registra un nuevo usuario.              |
| `POST`   | `/api/login`           | Registra un nuevo usuario.              |
| `PUT`    | `/api/usuarios/{id}`   | Actualiza la información de un usuario. |
| `DELETE` | `/api/usuarios/{id}`   | Elimina un usuario.                     |

### **📅 Seguimiento Diario**
| Método   | Endpoint                        | Descripción                           |
|----------|---------------------------------|---------------------------------------|
| `GET`    | `/api/seguimientos/{usuarioId}` | Obtiene el historial de seguimiento.  |
| `POST`   | `/api/seguimientos`             | Registra un nuevo seguimiento diario. |
| `DELETE` | `/api/seguimientos/{id}`        | Elimina un registro de seguimiento.   |

### **🔄 Fases del Ciclo**
| Método  | Endpoint             | Descripción                          |
|---------|----------------------|--------------------------------------|
| `GET`   | `/api/fases-ciclo`   | Lista las fases del ciclo menstrual. |

### **🤕 Síntomas**
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `GET`  | `/api/sintomas` | Obtiene la lista de síntomas. |

### **😊 Estados Emocionales**
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `GET`  | `/api/estados-emocionales` | Obtiene la lista de emociones. |

### **🔔 Notificaciones**
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `GET`  | `/api/notificaciones/{usuarioId}` | Obtiene los recordatorios del usuario. |

---

## 🚨 **Manejo de Errores**
| Código | Mensaje | Descripción |
|--------|---------|-------------|
| `400` | `Bad Request` | Datos inválidos en la solicitud. |
| `401` | `Unauthorized` | Token de autenticación inválido o faltante. |
| `403` | `Forbidden` | No tienes permisos para esta acción. |
| `404` | `Not Found` | Recurso no encontrado. |
| `500` | `Internal Server Error` | Error interno del servidor. |

---

## 🔐 **Seguridad y Autenticación**
- Se usa **JWT (JSON Web Token)** para la autenticación.
- Cada solicitud protegida requiere un **Bearer Token** en los headers.
- Se utiliza **BCrypt** para almacenar contraseñas en la base de datos.

---

## 🔄 **Lógica de Negocio**
1. **Registro de Usuarios:**
    - Un usuario se registra con nombre, correo y contraseña encriptada.
2. **Seguimiento Diario:**
    - Cada día, el usuario puede registrar síntomas, emociones y otros datos.
3. **Cálculo de Fase del Ciclo:**
    - La API puede predecir la fase en función de los datos previos.
4. **Notificaciones:**
    - Se pueden configurar recordatorios para días clave del ciclo.

---