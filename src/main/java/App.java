import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      String teamName = request.queryParams("teamName");
      if(teamName != null) {
        Team newTeam = new Team(teamName);
        ArrayList<Team> teams = request.session().attribute("teams");
        model.put("teams", request.session().attribute("teams"));
        if (teams == null) {
          teams = new ArrayList<Team>();
          request.session().attribute("teams", teams);
        }
      }
      model.put("teamAll", Team.getAllTeams());
      model.put("template", "templates/index.vtl");
      model.put("template2", "templates/TeamForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("teams/:id/member/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team newTeam = Team.find(Integer.parseInt(request.params(":id")));
      // model.put("teams", teams);
      model.put("template", "templates/memberForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/memberForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/TeamForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/teams/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // Team newTeam = Team.find(Integer.parseInt(request.params(":id")));
      // model.put("team", team);
      String name = request.queryParams("name");
      String language = request.queryParams("language");
      String skill = request.queryParams("skill");
      Member newMember = new Member(name, language, skill);
      Team teamCollection = Team.find(Integer.parseInt(request.queryParams("I")));
      Team.addMember(newMember);
      model.put("team", teamCollection);
      model.put("template", "templates/memberform.vtl");
      model.put("template", "templates/members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("teams/inventory", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("team", Team.getMember());
      model.put("member", Member.all());
      // model.put("template", "templates/index.vtl");
      model.put("template", "templates/allTeams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id/members/:memberId", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Member newMember = Member.find(Integer.parseInt(request.params(":memberId")));
      Team newTeam = Team.find(Integer.parseInt(request.params(":id")));
      // model.put("member", member);
      // model.put("team", team);
      model.put("template", "templates/allTeams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/members/all-members", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     String name = request.queryParams("name");
     Team newTeam = new Team(name);
     model.put("template", "templates/memberView.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
