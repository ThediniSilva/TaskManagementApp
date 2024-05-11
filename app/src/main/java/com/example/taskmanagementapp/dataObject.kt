package com.example.taskmanagementapp

object dataObject {
    var listdata = mutableListOf<taskInfo>()

    fun setData(title: String, Description:String, priority: String,Deadline:String) {
        listdata.add(taskInfo(title, Description,priority,Deadline))
    }

    fun getAllData(): List<taskInfo> {
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getData(pos:Int): taskInfo {
        return listdata[pos]
    }

    fun deleteData(pos:Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos:Int,title: String, Description:String, priority: String,Deadline:String)
    {
        listdata[pos].title=title
        listdata[pos].Description=Description
        listdata[pos].priority=priority
        listdata[pos].Deadline=Deadline
    }

}
