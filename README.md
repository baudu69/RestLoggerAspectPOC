## Example REST Logger console

Ce poc utilise le starter Spring boot AOP pour proposer un
component [AspectComponent](src/main/java/com/example/restloggeraspectpoc/AspectComponent.java) qui va executer la
méthode [logRestConsole](src/main/java/com/example/restloggeraspectpoc/AspectComponent.java).

Cette méthode va récupérer le nom et les arguments de toutes les méthodes des classes dont le nom finis par *Controller.java*
dans le package *com.example.restloggeraspectpoc* et va les logger dans la console.
