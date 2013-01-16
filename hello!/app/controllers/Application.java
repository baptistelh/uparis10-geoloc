package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {
    /*
    public static void index() {
        render();
    }*/
    public static void index() {
	Utilisateur u = Utilisateur.find("byPseudo","daVay").first();
	render(u);
    }
}
