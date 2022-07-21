# LoginForGmailByJesus
**Prueba de Cantera Digital** para dar Practicas Profesionales, consta de simular un Pequeño LogIn Para Gmail hecho en Kotlin

Como funciona es que se usan SharedPrefences Para guardar los datos del usuario y la sesion activa.
No se conecta directamente con Gmail, puesto que solo es un simulador de como hacer un login.

Una vez que Registras a un usuario se guarda en la SharedPrefences y mantendras la sesion activa incluso si sales de la app.

**Nota Importante**: No guarda varios usuarios, asi que si registras varios , se iran sobreescribiendo el registro de SharedPrefences y por ende solo podras acceder con la información del ultimo usuario registrado.
