# BackEnd


API con las funciones necesarias para un CRUD de una tabla Libro.

REQUISITOS
SQL SERVER
JDBC SQL SERVER
JDK
JEE
APACHE NETBEANS

PROCEDIMIENTO
Creear una tabla en cualquier base de datos que usted disponga ejecutando el siguiente script:

//Script

  CREATE TABLE [dbo].[Libro](
  [nombre] [varchar](150) NOT NULL,
  [descripcion] [varchar](300) NULL,
  [autor] [varchar](150) NULL,
  [fecha] [date] NULL,
  [ejemplares] [int] NULL,
  [costo] [numeric](18, 4) NULL,
  CONSTRAINT [PK_Libro] PRIMARY KEY CLUSTERED 
  (
  [nombre] ASC
  )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
  ) ON [PRIMARY]
  
  
Una vez creada la base de datos con su tabla, empezamos a levantar nuestro servidor de Glass Fish para proceder a configurar las conexciones Connection Pools y JDBC Resources con los datos de la base de datos respectivamente. Es importante verificar el PING de la conexión con la base sea correcto.

Finalmente el API con su método principal GET, se encontrará en el siguiente URL = http://localhost:8080/Libro/api/libros
