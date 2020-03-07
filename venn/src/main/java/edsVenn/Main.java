package edsVenn;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

	 
	
	“His palms 
	are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. He's nervous, 
	but on the surface, 
	he looks calm and ready. 
	To drop bombs, but he keeps on 
	forgettin. 
	What he wrote down, 
	the whole crowd goes so loud. 
	He opens his mouth, 
	but the words 
	won't come out. 
	He's chokin' how, 
	everybody's jokin' now. 
	The clocks runs out, 
	time's up, 
	over. Blow” 
	(Eminem, 2002)!

	After clicking enter, 
	the 
	following 328 
	characters should 
	be displayed,
	”His palms are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. 
	He's nervous, 
	but on the surface, 
	he looks calm 
	and ready. 
	To drop bombs, 
	but he keeps on forgettin. 
	What he wrote down, 
	the whole 
	crowd goes so loud. 
	He opens his mouth, 
	but the words won't come out. 
	He's chokin' how, 
	everybody's jokin' now” (Eminem, 2002).

	due to the 328-character limit per object.

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:
		 */
	/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

	 
	
	“His palms 
	are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. He's nervous, 
	but on the surface, 
	he looks calm and ready. 
	To drop bombs, but he keeps on 
	forgettin. 
	What he wrote down, 
	the whole crowd goes so loud. 
	He opens his mouth, 
	but the words 
	won't come out. 
	He's chokin' how, 
	everybody's jokin' now. 
	The clocks runs out, 
	time's up, 
	over. Blow” 
	(Eminem, 2002)!

	After clicking enter, 
	the 
	following 328 
	characters should 
	be displayed,
	”His palms are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. 
	He's nervous, 
	but on the surface, 
	he looks calm 
	and ready. 
	To drop bombs, 
	but he keeps on forgettin. 
	What he wrote down, 
	the whole 
	crowd goes so loud. 
	He opens his mouth, 
	but the words won't come out. 
	He's chokin' how, 
	everybody's jokin' now” (Eminem, 2002).

	due to the 328-character limit per object.

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:
		 */
	
	/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

	 
	
	“His palms 
	are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. He's nervous, 
	but on the surface, 
	he looks calm and ready. 
	To drop bombs, but he keeps on 
	forgettin. 
	What he wrote down, 
	the whole crowd goes so loud. 
	He opens his mouth, 
	but the words 
	won't come out. 
	He's chokin' how, 
	everybody's jokin' now. 
	The clocks runs out, 
	time's up, 
	over. Blow” 
	(Eminem, 2002)!

	After clicking enter, 
	the 
	following 328 
	characters should 
	be displayed,
	”His palms are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. 
	He's nervous, 
	but on the surface, 
	he looks calm 
	and ready. 
	To drop bombs, 
	but he keeps on forgettin. 
	What he wrote down, 
	the whole 
	crowd goes so loud. 
	He opens his mouth, 
	but the words won't come out. 
	He's chokin' how, 
	everybody's jokin' now” (Eminem, 2002).

	due to the 328-character limit per object.

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:
		 */
	/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

	 
	
	“His palms 
	are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. He's nervous, 
	but on the surface, 
	he looks calm and ready. 
	To drop bombs, but he keeps on 
	forgettin. 
	What he wrote down, 
	the whole crowd goes so loud. 
	He opens his mouth, 
	but the words 
	won't come out. 
	He's chokin' how, 
	everybody's jokin' now. 
	The clocks runs out, 
	time's up, 
	over. Blow” 
	(Eminem, 2002)!

	After clicking enter, 
	the 
	following 328 
	characters should 
	be displayed,
	”His palms are sweaty, 
	knees weak, 
	arms are heavy. 
	There's vomit on 
	his sweater already, 
	mom's spaghetti. 
	He's nervous, 
	but on the surface, 
	he looks calm 
	and ready. 
	To drop bombs, 
	but he keeps on forgettin. 
	What he wrote down, 
	the whole 
	crowd goes so loud. 
	He opens his mouth, 
	but the words won't come out. 
	He's chokin' how, 
	everybody's jokin' now” (Eminem, 2002).

	due to the 328-character limit per object.

“His palms 
are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. He's nervous, 
but on the surface, 
he looks calm and ready. 
To drop bombs, but he keeps on 
forgettin. 
What he wrote down, 
the whole crowd goes so loud. 
He opens his mouth, 
but the words 
won't come out. 
He's chokin' how, 
everybody's jokin' now. 
The clocks runs out, 
time's up, 
over. Blow” 
(Eminem, 2002)!

After clicking enter, 
the 
following 328 
characters should 
be displayed,
”His palms are sweaty, 
knees weak, 
arms are heavy. 
There's vomit on 
his sweater already, 
mom's spaghetti. 
He's nervous, 
but on the surface, 
he looks calm 
and ready. 
To drop bombs, 
but he keeps on forgettin. 
What he wrote down, 
the whole 
crowd goes so loud. 
He opens his mouth, 
but the words won't come out. 
He's chokin' how, 
everybody's jokin' now” (Eminem, 2002).

due to the 328-character limit per object.

/* Acceptance Test Cases
	 * •	If the user clicks 
	 * the middle 
	 * of the Venn 
	 * diagram and types, 
	 * after deleting 
	 * ‘This is text number 1’:
		 */
}
