terraform {
  required_version = ">= 1.0.0"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "ap-south-1"
}

#------------------------------------------------------------------------------
# Cria Log Group Cloudwatch
#------------------------------------------------------------------------------
module "cloudwatch" {
  source         = "./modules/cloudwatch"
  micro_services = var.micro_services
}

#------------------------------------------------------------------------------
# Cria Security Group
#------------------------------------------------------------------------------
module "security_group" {
  source = "./modules/security-group"
  vpc_id = var.vpc_id
}

#------------------------------------------------------------------------------
# Cria Roles
#------------------------------------------------------------------------------
module "iam_roles" {
  source               = "./modules/iam-roles"
  region               = var.region
  ecr_repository_names = var.ecr_repository_names
}

#------------------------------------------------------------------------------
# Cria Cluster ECS
#------------------------------------------------------------------------------
module "cluster_ecs" {
  source = "./modules/cluster-ecs"
}

#------------------------------------------------------------------------------
# Cria Service e Task
#------------------------------------------------------------------------------
module "ecs_app" {
  source             = "./modules/ecs"
  micro_service_name = "rate-limit"
  public_subnets     = var.public_subnets
  ecr_repository     = var.poc_metrics_ecr_repository
  execution_role_arn = module.iam_roles.ecs_execution_role_arn
  task_role_arn      = module.iam_roles.ecs_task_role_arn
  ecs_cluster_name   = module.cluster_ecs.ecs_cluster_poc_metrics
  security_groups = [module.security_group.ecs_sg_id]
  datadog_api_key    = var.datadog_api_key
  cpu                = 2048
  memory             = 4096
  region             = var.region
  container_port     = 8080
  host_port          = 8080
}