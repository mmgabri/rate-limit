<#
PowerShell script to download jmx_prometheus_javaagent.jar into the ./jmx directory.
Usage (Windows PowerShell):
  .\scripts\download-jmx-agent.ps1
#>

$ErrorActionPreference = 'Stop'

$version = '0.17.0'
$filename = 'jmx_prometheus_javaagent.jar'
$url = "https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/$version/jmx_prometheus_javaagent-$version.jar"

$destDir = Join-Path -Path (Split-Path -Parent $PSScriptRoot) -ChildPath 'jmx'
if (-not (Test-Path $destDir)) {
    New-Item -ItemType Directory -Path $destDir | Out-Null
}

$destPath = Join-Path $destDir $filename
Write-Host "Downloading $url to $destPath ..."

Invoke-WebRequest -Uri $url -OutFile $destPath
Write-Host "Downloaded to $destPath"

