cd C:\Users\tzvi\Desktop\Huji_Hackathon\AnimalFriendConnector

$seconds_wait = 0


while($true){

    $size_var = Get-Content -Path C:\Users\tzvi\Desktop\Huji_Hackathon\AnimalFriendConnector\resource.txt


    if($seconds_wait -ne $size_var[0])
    {
        $seconds_wait = $size_var[0]
    }


    Start-Sleep -s $seconds_wait


    Get-Process | Where-Object { $_.MainWindowTitle} | Where-Object { $_.ProcessName -ne "powershell_ise"} | Where-Object { $_.ProcessName -ne "zoom"} | kill 
    Start-Process java '-jar C:\Users\tzvi\Desktop\Huji_Hackathon\AnimalFriendConnector\AnimalFriendConnector.jar'
    $p = Get-Process java
    Wait-Process -Id $p.id

}
    


