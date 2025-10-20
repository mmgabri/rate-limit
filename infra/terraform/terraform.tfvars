region = "ap-south-1"

vpc_id = "vpc-0937c412a9ca27b93"

public_subnets = [
  "subnet-09555f0e6a712f151",
  "subnet-0e2c6d629a801dfd4",
  "subnet-0653af21750a769f2"
]

micro_services = [
  "rate-limit", "datadog-agent"
]

ecr_repository_names = [
  "140023369634.dkr.ecr.ap-south-1.amazonaws.com/rate-limit"
]

poc_metrics_ecr_repository = "140023369634.dkr.ecr.ap-south-1.amazonaws.com/rate-limit"

datadog_api_key = "432ae4eb0e2702b3c572587400077c09"