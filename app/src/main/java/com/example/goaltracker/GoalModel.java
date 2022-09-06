package com.example.goaltracker;

public class GoalModel {
    String GoalName;
    String ProgressPercentage;
    String Importance;
    String Category;
    String Description;
    String Duedate;


    public GoalModel(String goalName, String progressPercentage, String importance,String duedate, String category, String description)
    {
        GoalName = goalName;
        ProgressPercentage = progressPercentage;
        Importance = importance;
        Category = category;
        Description = description;
        Duedate = duedate;
    }

    public int getimagecolor(String Importance){
        if (Importance=="Very Important"){
            return(R.drawable.importance0);
        }
        else if (Importance=="Important"){
            return(R.drawable.important1);
        }
        else return R.drawable.impotance2;
    }

    public java.lang.String getDuedate() {return Duedate;}
    public String getGoalName() {
        return GoalName;
    }
    public String getProgressPercentage() {return ProgressPercentage;}
    public String getImportance() {
        return Importance;
    }
    public String getCategory() {
        return Category;
    }
    public String getDescription() {
        return Description;
    }
}
