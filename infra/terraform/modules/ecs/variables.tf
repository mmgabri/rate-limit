#variables.tf
variable "public_subnets" {
  description = "Lista de subnets públicas"
  type        = list(string)
}

variable "ecr_repository" {
  description = "Nome do repositório ECR para o serviço router"
  type        = string
}

variable "execution_role_arn" {
  description = "Role de Execução"
  type        = string
}

variable "task_role_arn" {
  description = " Role de Tarefa"
  type        = string
}

variable "ecs_cluster_name" {
  description = "Nome do cluster"
  type        = string
}

variable "security_groups" {
  description = "Lista de IDs dos Security Groups para o NLB"
  type        = list(string)
}


variable "micro_service_name" {
  description = "Nome do micro serviço"
  type        = string
}

variable "cpu" {
  description = "CPU task"
  type        = string
}

variable "memory" {
  description = "Memória Task"
  type        = string
}

variable "region" {
  description = "Region"
  type        = string
}

variable "container_port" {
  description = "Container Port"
  type        = number
}
variable "host_port" {
  description = "Host Port"
  type        = number
}

variable "datadog_api_key" {
  description = "Api key datadog"
  type        = string
}
