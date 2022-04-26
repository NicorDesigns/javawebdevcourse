### Jakarta JEE 8 Web Expression Language


##### [Jakarta Expression Language Start Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-session-management-start)

#### 1. Understanding Expression Language

In order to properly separate the Front End Presentation Layer from the Back End Bussiness Layer it is strongly discouraged to use embedded Java code in JSPs. 
For presentation layer logic such as iterating through a list we will use the Expression Language


##### Introducing The Jakarta EL 4.0 (Jakarta EE 8)

[EL 4.0 Documentation:](https://jakarta.ee/specifications/expression-language/4.0/)

[EL 4.0 Specification:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html)

[Jakarta EL Maven Co-ordinates](https://mvnrepository.com/artifact/jakarta.el/jakarta.el-api)

Which falls or is related to the 
[Jakarta JSP Specification:](https://jakarta.ee/specifications/pages/)

##### A look at Eval Expressions

[https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#eval-expression](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#eval-expression)

From the official documentation:

"For instance, by convention the Jakarta EE web tier specifications use the `${expr}` construct for immediate evaluation and the `#{expr}` construct for deferred evaluation. This difference in delimiters points out the semantic differences between the two expression types in the Jakarta EE web tier. Expressions delimited by `#{}` are said to use “deferred evaluation” because the expression is not evaluated until its value is needed by the system. Expressions delimited by `${}` are said to use “immediate evaluation” because the expression is compiled when the JSP page is compiled and it is executed when the JSP page is executed. More on this in [Section 1.2.4, “Syntax restrictions”](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#syntax-restrictions)."

One caveat here is that many Javascript frameworks such as JQuery uses the same syntax and to resolve this issue you have to use the HTML Escape or better yet use the 
 jsp-property-group> and deferred-syntax-allowed as literal.


##### Where can you put Expressions in a JSP

You can place Expressions anywhere in a JSP except inside a directive such as 

			<%@ page >
or within a declaration such as
			
			<%= >
because these are pre-compiled with JSP
An example that you've already seen is within text such as Hello User

			Hello ${expr}

that will display the users name.

You can also put expressions inside HTML and JSP tags for assigning attribute values as text color , font etc. You can also use the inside inline javascript and Cascading Style Sheets


#### 2. Writing with the EL Syntax


Expression language like Javascript is loosely typed but it still adheres to a rigourus syntax. Expressions always has to evaluate to a value and you can assign the expression to a value

##### [Reserved words: ](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#reserved-words) 

These reserved words more or less perform the same functions as you are used to in Java 

##### [Literal Expression:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#literal-expression)

Both are basically the same as you are used to in Java

##### [Operator Precedence:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#operator-precedence)

Note the second to last Lamda Expression which also appeared in Java 8

#####[Literal Values:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#literals)

Strings can have both double quotes and single quotes as in Javascript, you much take care when using strings in HTML and JSP tag attributes tough because you can end up wasting a day or more with weird syntax errors in your JSP. 
When dealing with special characters in non-english languages you will also often have to use the escape syntax.
Another thing to note is that numeric values are not explicity typed like Java but dynamically typed.

##### [Collections Construction:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#construction-of-collection-objects)

##### [Collection Operations:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#collection-operations)

##### [Resolution of Model Objects and their Properties or Methods:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#resolution-of-model-objects-and-their-properties-or-methods)

##### [EL Functions:](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#functions)

Not to be confused by [Lambda Expressions](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#functions-2) which are also known as Functions and documented as such



##### [API DOC](https://jakarta.ee/specifications/expression-language/4.0/apidocs/)


##### [Static Field and Method Reference](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#static-field-and-method-reference)


##### [Enums](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#enums)

Can be mapped from Java to the expression language:

##### [Jakarta EL Lambda Expressions](https://jakarta.ee/specifications/expression-language/4.0/jakarta-expression-language-spec-4.0.html#enums)




#### 3. Using scoped variables in EL expressions 

[Implicit Variables:](https://jakarta.ee/specifications/platform/9/apidocs/jakarta/servlet/jsp/el/implicitobjectelresolver)

EL Implicit Variables and Implicit Scope


This involves the WROX User-Profile Example

##### [Jakarta Expression Language Finish Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-session-management-finish)

    

