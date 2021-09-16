
# Java code conventions
## Naming conventions
-   **Classes, fields, methods, and varibles** are written in CamelCase. No underscores used with one exception CONSTANTS, constants are all in caps with underscored separating words
- **Classes and Interfaces** always start with an Uppercase letter and are generally nouns or noun-phareses.
- **Methods** begin with a lowercase letter. Procedures generally begin with verbs while functions generally begin with noun phrases that explain what value is the function returning. However boolean functions are usually named as questions.
- **Variable** names start with a lower case letter and are descriptive of the meaning. However, long descriptive names can dirty the code and make it look mor confusing. So a compromise has to be made, the variable has to be descriptive enough to understand its meaning but not too long.
- **Package** names are usually lower case and nouns.
## Format conventions
- The position of braces {} should be consistent through all the program.
- Only one statement per line (in most cases).
- Maximum of 80 characters per line.
- Indentation. Substatements of statement or declaration should be indented.
- Put a space between the keyword and the following parenthesis, to differentiate control structures from method calls. (Applies to ifs, whiles, fors,etc)
- Put a spaces on both sides of the equal sign on assignations. As well as other operators.
## Documentation
- Comments that start with "//" are one-line comments: the comment ends at the end of the line
- Comments that start with "/*" must end with "*/", but they may span many lines
- A Javadoc comment starts with "/**"  and therefore ends with "*/". Javadoc stands for "Java documentation"
#### Method specifications
Every method should be preceded by a blank line and then a Javadoc specification that describes what the method does, along with preconditions ---constraints on the arguments of a call. In order to do this properly, the specification must mention each parameter, indicating what it is for.
#### Class specifications
Each public class is given in a separate file. The beginning of the file should contain a javadoc comment that explains what the class is for. This can be a simple, short summary. Often, one also puts here information concerning the author, the date of last modification, and so on.
## General code organization
-   Field and class variable declarations go at the beginning of a class
    
-   Keep methods short. Rarely should a method be over 50 lines.
    
-   Use returns to simplify method structure.
    
-   Declare local variables close to first use
- Packages are lowercase and only one word
